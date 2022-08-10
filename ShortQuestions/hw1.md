1. LearnMarkDownandshowallofbasicusageintheShortQuestions/README.md
    1. https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formattin g-on-github/basic-writing-and-formatting-syntax
2. practicegitusingtheplatform.listthegitcommandsyoulearned
    1. https://learngitbranching.js.org/
    git commit
    git cherry-pick
    git pull
    git clone
    git remote
    git fetch
    git branch
    git add
    git reset
    git merge
    git log
    git show
    git rebase
    git rev-list
    git status
    git checkout
    git push
    git describe
    git tag
    git switch
2. What is the basic steps to init a git repo in you local?
    create a folder in local to store the code and resources
    use command git init
    write code in the folder
3. How to clone a repo from Github?
    use command git clone XXX
4. How to create a new branch and checkout to that branch?
    use command git branch XXX
    use command git checkout XXX
5. How to merge the branch_test to master branch in command?show me the commands
    git checkout master
    git merge branch_test 
6. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way.
    1. commands way 
    git checkout branch_learn_stash
    git stash
    git checkout branch_learn_stash
    git stash pop
    2.intellij way
    
7. How do you understand PR is based on Branch?
    Pull Request is to merge two remote branches (code owner's branch and code contributor's branch).
8. What is maven role?what it be used to do?
    Maven is an open source software project management tool based on the project object model under Apache. Maven can be used to download dependencies of referenced libraries or JAR files.
9. What is the lifecycle of maven? could you tell me the details ?
    The lifecycle of a typical Maven build includes validate, compile, test, package, verify, install, and deploy. 
10. what is the difference between package and install in maven lifecycle ?
    package step is to package the compiled code in distributed format like JAR or WAR
    install step is to install the packaged project to the local repository for use by other projects
11. What is plugins in maven, list some plugins.
    The core of maven only defines the abstract life cycle, and the specific tasks are handed over to the plugin to complete.
    For example, the maven-compiler-plugin can complete the task of compile in the compile phase of the lifecycle.
12. In chuwa0808, MavenProject directory, create a maven Module using Intellij, named it as belows:
    1.  groupID:com.chuwa.learn
    2.  artifactID:java-core
13. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other
students' PR, please don't merge it.
