### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md

Please check the link below

[README](ShortQuestions/README.md)

### 2. practice git using the platform. list the git commands you learned
	
```
git commit
git branch
git checkout
git checkout -b
git merge
git rebase
git checkout c4 
git checkout bugFix^
git branch -f main HEAD~1
git reset HEAD~1
git revert HEAD
```
   
### 3. What is the basic steps to init a git repo in you local ?
```
//init the directory to be git can manage
git init
	
//add any file to the repo
git add

//commit the repo
git commit
```
### 4. How to clone a repo from Github ?
```
git clone https or SSH
```
### 5. How to create a new branch and checkout to that branch ?
```
// create a new branch, or create a new branch then switch to it
git branch nameOfBranch or git checkout -b nameOfBranch

//checkout
git branch // see existing branchs
git checkout nameOfBranch
	
```
### 6. How to merge the branch_test to master branch in command ? show me the commands

```
git checkout master
git merge branch_test
```

### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way.

**1. git commands:**

```
git status
git stash
git status

//create a branch for fix, and assume we need to fix bug on main branch
git checkout main
git checkout -b bugFix
git add .
git commit -m "bug fixed"

//back to main branch
bit checkout main
	
//merge bugFix and main
git merge bugFix

//delete the branch bugFix
git branch -d bugFix

//back to branch_learn_stash
git checkout branch_learn_stash
	 
//pop stash
git stash pop
```

**2. Intellij way:**

- find the git feature in Intellij 
- double click on the option "Local Changes" and select the code that needs to be stashed 
- right-click, and select "Shelve Changes."
- Write the commit message in order to realize the version when we need 
- Click "Shelve Changes."

After fixing the bug, go back to the branch_learn_stash
- go to the option "Shelf and" select the version we need to restore
- right-click "Unshelve."
- In the end, click "unshelve changes."


### 8. How do you understand PR is based on Branch?


First, without a branch, there won't be a pull request feature. 
Therefore Pr is based on Branch since PR is a request for a specific branch that wants to merge with another branch. For instance, 
if a programmer wants to contribute to an open source project on GitHub or GitLab, he/her needs to fork the repo, 
which leads to the programmer having the same repo under their account. After then, the programmer can do whatever he/her wants to do to the repo under the account. 
In the end, the programmer wants to merge his repo with the open source; otherwise, the programmer is not contributing anything, 
so the programmer raises a Pull Request to merge the open source project; moreover, 
once the owner accepts the PR, the programmer did contributes something to the open source project.



### 9. What is maven role ? what it be used to do ?

- Easy to build a project by Maven 

- Since we might use a lot of third-party libraries, like jar package, 
	and we don't like to waste any time on building a jar package environment, 
	in this case, we merely tell Maven what kind of jar package we need, it will download them for us.

- Maven provides information such as log doc dependency list etc.

- Easily corporate with other source control system like git
### 10. What is the lifecycle of maven? could you tell me the details ?

- the lifecycle of maven is build/default, clean, and site lifecycle

**Details:**

- validate: Validate: validates if the project structure is correct, like check if all the dependencies are downloaded in the local repo
- Compile: It comailes the source code, convert the .java file to .class and stores the classes in target/classes floder
- Test: test the compiled source code
- Package: Package the compiled code into proper format like JAR or WAR
- Verify: checks to verify that the project is valid and meets the quality standards
- Install: install the packaged code to the local repo for use as a dependency in other projects locally
- Deploy: It copies the packaged code to the remote repository for sharing it with other developers
   
### 11. what is the difference between package and install in maven lifecycle ?

Even though both **Package** and **Install** compile and package the code, 
for the **Package**, it will package the code into a proper format like JAR or WAR; 
for the **Install**, after the packaging process, it will also download the code to the local repo as a dependency for another project to use.

### 12. What is plugins in maven, list some plugins.

In general, **Maven** is a collection of **Plugins**, which means **Plugins** are where almost the action is operated. 
It can be used to create JAR files, a WAR file, compile code, unit test code, etc. 
Even if both **plugins** and **dependencies** are Jar files, most of the work in Maven is done by **plugins**.

Plugins:
- clean: Once the build is completed, these plugins cleans it up
- failsafe: used to run the JUnit integration in isolated classloader
- site: The generation of the site for a project is done with the site plugin
- verifier: To verify certain conditions, and to ensure integration tests, the verifier plugin is useful

### 13. In chuwa0808, MavenProject directory, create a maven Module using Intellij, named it as belows:
1. groupID: com.chuwa.learn
2. artifactID: java-core

cheak the link below:

[module](MavenProject\module\pom.xml)

### 14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it.