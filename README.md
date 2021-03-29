# android-mvvm-sample


## sop - A new android project to a new github Repository

1. Android studio create new project
 
       when project created, .gitignore was generated

2. let project as a new github repository

       Android studio : VCS > import into vesrion control > share project on github > Use Token

       github(generate access token for android studio) :
        github > list : Settings > Developer setting > Personal access tokens > generate new token > checked to select permissions
         > Generate token > copy token code > return to android studio

       Android studio : paste token code > log in > check what permissions not supported and back to github to add them

       github : click 'tokenName' to setting > add not supported permissions > Update token > back to Android studio

       Android studio : log in > edit repositoryName(e.g. android-mvvm-sample), remote, Description > Add
       
## sop2 - use this template project to start a new application       

1. clone this project from github

2. execute copy_android_project.bat 

       ps:
        powershell -Command "(gc test\settings.gradle) -replace 'arcComponetsSample', '$projectName' | Out-File test\settings.gradle"
        這行會出錯無法加到 bat

3. Android Studio open this project

4. 

       a. Gradle Scripts > settings.gradle : 
          replace 'arcComponetsSample' to $projectName e.g. 'test'
       b. shift + F6 to rename package
       c. AndroidManifest.xml : rename style/Theme => $projectName
       d. build.gradle : applicationId arccomponetssample => $projectName
 
5. add to git by refering SOP document(sop - A new android project to a new github Repository)

6. run this project
