# HelloWorld
入门示例代码

Git如何检出指定目录或文件 https://segmentfault.com/a/1190000006703926
git init
git config core.sparseCheckout true
git config --list
echo /springmvc_mybaties/* >> .git/info/sparse-checkout
echo /readme.md >> .git/info/sparse-checkout
