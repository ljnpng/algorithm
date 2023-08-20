#!/opt/homebrew/bin/python3

# Required parameters:
# @raycast.schemaVersion 1
# @raycast.title leetcode issue
# @raycast.mode compact

# Optional parameters:
# @raycast.icon 🤖
# @raycast.argument1 { "type": "text", "placeholder": "Placeholder" }
# @raycast.packageName leetcode

# Documentation:
# @raycast.description create github issue which include a specific leetcode problem
# @raycast.author ele.hope
# @raycast.authorURL https://raycast.com/ele.hope

import json
import os
import re
import sys

import requests

Remove = ["</?p>", "</?ul>", "</?ol>", "</li>", "</sup>"]
Replace = [["&nbsp;", " "], ["&quot;", '"'], ["&lt;", "<"], ["&gt;", ">"],
           ["&le;", "≤"], ["&ge;", "≥"], ["<sup>", "^"], ["&#39", "'"],
           ["&times;", "x"], ["&ldquo;", "“"], ["&rdquo;", "”"],
           [" *<strong> *", " **"], [" *</strong> *", "** "],
           [" *<code> *", " `"], [" *</code> *", "` "], ["<pre>", "```\n"],
           ["</pre>", "\n```\n"], ["<em> *</em>", ""], [" *<em> *", " *"],
           [" *</em> *", "* "], ["</?div.*?>", ""], ["	*</?li>", "- "]]


def convert(src):
    # pre内部预处理
    def remove_label_in_pre(matched):
        tmp = matched.group()
        tmp = re.sub("<[^>p]*>", "", tmp)  # 不匹配>与p
        return tmp

    src = re.sub("<pre>[\s\S]*?</pre>", remove_label_in_pre,
                 src)  # 注意此处非贪心匹配，因为可能有多个示例
    # 可以直接删除的标签
    for curPattern in Remove:
        src = re.sub(curPattern, "", src)
    # 需要替换内容的标签
    for curPattern, curRepl in Replace:
        src = re.sub(curPattern, curRepl, src)
    return src


def get_question_detail(slug: str) -> dict:
    """根据题目的 id 获取题目的名字，内容，代码块，标签，返回 json 格式的 dict 对象
    """
    user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.122 Safari/537.36"
    session = requests.Session()
    url = "https://leetcode.cn/graphql"
    params = {
        'operationName': 'questionData',
        'variables': {
            'titleSlug': slug
        },
        'query':
            '''query questionData($titleSlug: String!) {
            question(titleSlug: $titleSlug) {
                questionId
                questionFrontendId
                title
                titleSlug
                content
                translatedTitle
                translatedContent
                difficulty
                topicTags {
                    name
                    slug
                    translatedName
                    __typename
                }
                codeSnippets {
                    lang
                    langSlug
                    code
                    __typename
                }
                __typename
            }
        }'''
    }
    json_data = json.dumps(params).encode('utf8')
    # plus 题库才需要登陆信息
    leetcode_session = open(os.path.join(os.environ['HOME'], '.leetcode-session'), 'r').read().strip()

    headers = {
        'User-Agent': user_agent,
        'Connection': 'keep-alive',
        'Content-Type': 'application/json',
        'Referer': 'https://leetcode.cn/problems/' + slug,
        'Cookie': leetcode_session,
    }
    resp = session.post(url, data=json_data, headers=headers, timeout=10)
    resp.encoding = 'utf8'
    content = resp.json()
    # 题目详细信息
    # print(content)
    question = content['data']['question']
    return question


def get_problem_content(question: dict) -> str:
    res = convert(question['translatedContent'])
    # 在正文后面填上标签
    res += "\n \n**标签**\n"
    tags = question['topicTags']
    for tag in tags:
        if tag['translatedName'] is not None:
            tagName = tag['translatedName']
        else:
            tagName = tag['name']
        res += "`" + tagName + "` "

    res += "\n"
    return re.sub(r'\n\n\n\n*', "\n", res)  # 替换掉多个换行符


def get_solution_by_lang(question: dict, lang: str) -> str:
    """
        获取给定题目的对应语言的函数

        支持的参数如下

        C++ Java Python Python3 C C# JavaScript Ruby Swift Go Scala Kotlin
        Rust PHP TypeScript Racket
    """
    # 获取对应语言的函数
    codeSnippets = question['codeSnippets']
    for x in codeSnippets:
        if x['lang'] == lang:
            return x['code']


def gen_content(content, code, title, url):
    return """# {titlename}
[{Url}]({Url})
## 原题
{Content}

##
```java
{Code}

```
>
""".format(titlename=title, Url=url, Content=content, Code=code)


def get_issues(repo, token, state='all'):
    issues_url = f"https://api.github.com/repos/{repo}/issues"
    headers = {
        'Accept': 'application/vnd.github+json',
        'Authorization': 'Bearer ' + token
    }
    params = {'state': state}
    response = requests.get(issues_url, headers=headers, params=params)
    response.raise_for_status()
    return response.json()


def check_for_existing_issue(repo, title, token):
    issues = get_issues(repo, token)
    for issue in issues:
        if issue['title'] == title:
            return issue['html_url']
    return None


def gen_issue(url: str):
    if url.startswith("https://leetcode.cn/problems/"):
        slug = url.replace("https://leetcode.cn/problems/", "",
                           1).strip('/')
    else:
        print(
            "Wrong URL ! Please Check\n.It should be like https://leetcode.cn/problems/evaluate-division/"
        )
        return
    url = "https://leetcode.cn/problems/" + slug
    question = get_question_detail(slug=slug)
    title = question['questionFrontendId'] + '.' + question['translatedTitle']

    content = get_problem_content(question)
    code = get_solution_by_lang(question, 'Java')

    issue = {
        'title': title,
        'body': gen_content(content, code, title, url),
        'labels': ['leetcode'],
        'assignees': ['ljnpng']
    }

    return issue


def create_issue(url, token, repo='ljnpng/algorithm'):
    data = gen_issue(url)
    existing_issue_url = check_for_existing_issue(repo, data['title'], token)
    if existing_issue_url:
        print(f"An issue with the same title already exists: {existing_issue_url}")
        return

    # 自定义body
    data = json.dumps(data).encode('utf8')

    # 发起issue 请求

    headers = {
        'Accept': 'application/vnd.github+json',
        'Authorization': 'Bearer ' + token,
        'Content-Type': 'application/x-www-form-urlencoded',
    }
    repos = "https://api.github.com/repos/ljnpng/algorithm/issues"
    response = requests.post(url=repos, headers=headers, data=data)
    if response.status_code == 201:
        issue_url = response.json()['html_url']
        print(f"Issue created: {issue_url}")
        return issue_url
    else:
        print("Failed to create issue")
        sys.exit(1)


def preprocess_url(url):
    pattern = r"https://leetcode\.cn/problems/([^/]+)/"
    match = re.search(pattern, url)
    if match:
        processed_url = match.group(0)
        return processed_url
    else:
        print("Wrong URL ! Please Check\n.It should be like https://leetcode-cn.com/problems/evaluate-division/")
        sys.exit(1)


def main():
    if len(sys.argv) <= 1:
        url = input("Please input leetcode url, e.g. https://leetcode.cn/problems/merge-two-sorted-lists/")
    else:
        url = str(sys.argv[1])
    token_file = '.githubtoken'
    token = open(token_file, 'r')
    url = preprocess_url(url)
    create_issue(url, token.read().strip())


if __name__ == '__main__':
    main()
