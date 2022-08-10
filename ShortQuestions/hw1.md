# Answer to question 1
See README.md

# Answer to question 2
git commit — add branch on main

git branch — create a new branch at current main head

git checkout name — set the working direction to newImage

- git checkout name + git commit == git switch

- git checkout -b [branch_name] == git checkout name + git commit 

- git checkout — *放到这个上去，当前working direction

git merge — *在哪儿，就merge到谁上面

rebase:
- git checkout 被copy的
- git rebase 目标— copy一份 c2 -> c2’   c2’加在main下面，要先checkout c2, 然后git rebase main

git checkout “node_name” 可以把head pointer放过去， detaching head

git checkout bugFix — 拿到head pointer
git checkout bugFix^ — check parent

git checkout HEAD~4   head往上4个parent
git branch ~f main HEAD~3    main    bugFix*    只move main


undo change:
git reset
git revert

# Answer to question 3
$pwd — check the current working direction
$ cd cw/HW1
$git init

# Answer to question 4
$git clone https://github.com/url....

# Answer to question 5
git branch — create a new branch at current main head

git checkout name — set the working direction to the node named "name"

# Answer to question 6
merge branch_test to master:
- git checkout main;   //* point to main
- git merge branch_test   //merge the selected to main

# Answer to question 7
$git checkout branch_learn_stash

$git stash   //隐藏branch_learn_stash

$git stash pop  //恢复，可以继续操作，并且恢复的同时把stash内容也删了

Don't know how to do in intellij way, will update later


# Answer to question 8
You will work directly on the main track, whenever you want to make change, working on something, or update something, you need to create a branch 
and work on the branch instead. After you done editing on the branch, you will push your work to the main.

# Answer to question 9
Maven:
- Downloan, add and remove dependencies/libraries that imported (injected) from the external sources.
- Mnage build configurations and dependencies.
- A pom.xml is the manifest file for Maven.
- It is the configuration of how the project is comfiled, with what dependencies.

# Answer to question 10
lifeCycle of maven.

clean -> prepare-resources -> validate -> package -> install

# Answer to question 11
package -- where you create JAR/WAR file

install -- where install the generated package on your own working directory

# Answer to question 12
plugins: 
- Feature that hold by the central repository that can be used by many projects.
- Plugins are specified in pom.xml using plugins element.
- example: clean, compile, antrun, jar, war
