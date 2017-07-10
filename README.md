# HelloWorld
入门示例代码

Git如何检出指定目录或文件 https://segmentfault.com/a/1190000006703926
git init
git config core.sparseCheckout true
git config --list
echo /springmvc_mybaties/* >> .git/info/sparse-checkout
echo /readme.md >> .git/info/sparse-checkout

与远端关联
git remote -v
git remote add origin https://github.com/tdcuit/HelloWorld.git
git pull origin master

springmvc_mybaties 用jdk高版本如1.8会报java.lang.reflect.AnnotatedElement  class not fond.   用1.6吧
