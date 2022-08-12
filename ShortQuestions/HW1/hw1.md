# HW1

####1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
The answer can be viewed at ShortQuestions/README.md
####2. practice git using the platform. list the git commands you learned
1. git commit
2. git branch
3. git checkout
4. git merge
5. git rebase
6. git checkout HEAD^
7. git branch -f main HEAD~3
8. git checkout HEAD~4
9. git revert
10. git reset
11. git cherry-pick
####3. What is the basic steps to init a git repo in you local ?
1. create a folder first using 'mkdir'
2. go to the folder using 'cd dir'
3. 'git init'
####4. How to clone a repo from Github ?
'git clone url'
####5. How to create a new branch and checkout to that branch ?
1. 'git branch branchname'
2. 'git checkout branchname'
####6. How to merge the branch_test to master branch in command ? show me the commands
1. 'git checkout master'
2. 'git merge branch_test'
####7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
1. command way
   1. git checkout branch_learn_stash
   2. git stash
   3. git checkout branch_learn_stash
   4. git stash pop
2. intellij way
   1. click shelve changes option
   2. click unshelve button
####8. How do you understand PR is based on Branch?
PR means pull request, which means the target branch will merge to the main branch
####9. What is maven role ? what it be used to do ?
1. Maven is a build automation tool used primarily for Java projects. 
2. Maven can manage a project's libraries and dependencies which are libraries or JAR files .
####10. What is the lifecycle of maven? could you tell me the details ?
The lifecycle of maven are Validate, Compile, Test, Package, Integration test, Verify, Install and Deploy.
####11. what is the difference between package and install in maven lifecycle ?
1. package step: package and save the file as JAR file
2. install step: install the package into the local repository
####12. What is plugins in maven, list some plugins.
1. In Maven, there are two kinds of plugins, build and reporting:
   1. Build plugins are executed during the build and configured in the <build/> element.
   2. Reporting plugins are executed during the site generation and configured in the <reporting/> element.
2. maven-antrun-plugin & maven-jar-plugin are some examples
####13. In chuwa0808, MavenProject directory, create a maven Module using Intellij, named it as belows:
####14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it  