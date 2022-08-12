1.  Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
	
	1.  https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax  
2.  practice git using the platform. list the git commands you learned  
	1.  https://learngitbranching.js.org/
		1. git commit
		2. git push
		3. git checkout
		4. git branch
		5. git merge
		6. git rebase
		7. git checkout [someBranch]^
3.  What is the basic steps to init a git repo in you local ?  
	`git init`
4.  How to clone a repo from Github ?  
	`git clone`
5.  How to create a new branch and checkout to that branch ?
	`git branch [some branch]`
	`git checkout [some branch]`
6.  How to merge the branch_test to master branch in command ? show me the commands  
	`git checkout master`  
	`git merge branch_test`
7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you 
checkout back to **branch_learn_stash ? try commands way and intellij way.  
	`git checkout branch_learn_stash`	 
	`git stash`  
	`git checkout branch_learn_stash`  
	`git stash pop`  
	not sure how to do it in intellj 
8.  How do you understand PR is based on Branch?  
	`pull request is merging the one branch into the main branch`
9.  What is maven role ? what it be used to do ?
	1.Manage Dependencies
	2.Build Project
	3.Documentation
	4.Reporting
	5.Others
10.  What is the lifecycle of maven? could you tell me the details ?  
	`1. prepare-resource - Resource copying can be customized in this phase.`  
	`2. validate - Validates if the project is correct and if all necessary information is available`  
	`3. compile - Source code compilation is done in this phase`  
	`4. test - Tests the compiled source code suitable for testing framework`  
	`5. package - This phase creates the JAR/WAR package as mentioned in the packaging in POM.xml`  
	`6. install - This phase installs the package in local/remote maven repository`  
	` 7. deploy - Copies the final package to the remote repository.`  
11.  what is the difference between package and install in maven lifecycle ?  
	`package creates JAR/WAR packages and install the details of those packages`  
12.  What is plugins in maven, list some plugins.  
	`plugins are defined functions to work with maven`  
	some plugins:
		1. clean
		2. compiler
		3. jar
		4. war
13.  In chuwa0808, MavenProject directory, create a maven Module using Intellij, named it as belows:  
	1.  groupID: com.chuwa.learn  
	2.  artifactID: java-core
14.  Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other 
students' PR, please don't merge it.
