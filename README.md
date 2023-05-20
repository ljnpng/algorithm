# algorithm
算法练习

## 自动创建 github issue
1. open [Fine-grained access control with GitHub Apps](https://github.com/settings/tokens?type=beta)
2. create a new token
3. copy the token
4. create a file `~/.githubtoken` and paste the token
5. run the script (replace the url with your own)

```shell
python3 create-github-issue.py https://leetcode.cn/problems/merge-k-sorted-lists/
```
