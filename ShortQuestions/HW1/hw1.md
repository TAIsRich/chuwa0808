# [Git learning :](https://learngitbranching.js.org/)

## move parallel branch under main : git rebase main


# basic steps to init git repo in your local :

	1. mkdir repo
	2. cd repo
	3. git init

# clone repo :

	1. copy url
	2. git clone url

# create and checkout new branch :

	1. git branch <branch_name>
	2. git checkout <branch_name>

# merge the branch_test to master branch in command :
```
git ckeckout master
git merge branch_test
```

# stash new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash 

## command way :
```
git stash save <file>
git checkout main
git checkout branch_learn_stash
git stash pop
```

## Intellij way :

	1.Git, Uncommitted Changes, Stash Changes
	2.select the git root
	3.describe the changes
	4.Create Stash

# How do you understand PR is based on Branch?

## Branch allows different tasks to be carried out at the same time and PR is ask for merging other beaches to contribute

# What is maven role ? what it be used to do ?

- provide a standard project structure
- provide a standard building pcocess including compile, test...
- provide a dependent management machanism

## mainly used to manage and construct JAVA projects
 ### roles : 
 		- manage dependencies
 		- build project
 		- documentation
 		- reporting

# What is the lifecycle of maven? could you tell me the details ?
1. clean
2. default
3. site

*Validate* : check structure - dependencies have been downloaded and are available locally
*Compile* : compile source code, converts .java file to .class and store in target/class folder
*Test* : run unit tests
*Package* : packages compiled code in distributable format like JAR/WAR
*Integration test* 
*Verify* : check project is valid and meet the quality standards
*Install* :install packaged code to local maven repo
*Deploy* :copy packaged code to remote repo


# what is the difference between package and install in maven lifecycle ?

## package is only put together all the code into a JAR. 
## While install is to the local repo and means it's ready for being used as a dependency in other projects locally

# What is plugins in maven, list some plugins.

## plugins are used to acomplish each phase of maven life cycle. maven is actually an aggregation of plugins.
- clean
- compiler
- surefire
- jar
- war
- javadoc 
