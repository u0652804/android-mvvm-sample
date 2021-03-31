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

## sop3 - Develop tips and tool

1. Create data model with tool

webTool : https://codebeautify.org/json-to-java-converter

copy json data {"..."} to paste and conver to class code

when use tool to generate class, please 

 - change root key as your class name of data model
 - use @SerializedName method for gson convertion
 
 e.g. key is data, but generate var is Data. 

    @SerializedName("data")
    Data DataObject;

2. References about Restful method

 - Add access token : https://stackoverflow.com/questions/41078866/retrofit2-authorization-global-interceptor-for-access-token
 - Process exception about Retrofit : https://jefflin1982.medium.com/android-%E9%97%9C%E6%96%BCretrofil%E7%9A%84%E5%85%B6%E4%BB%96%E5%B0%8F%E4%BA%8B%E6%83%85-587609eb27e5 
 - Fix http request : https://stackoverflow.com/questions/39933345/no-network-security-config-specified-using-platform-default-android-log
 - Reference of Retrofit : https://stackoverflow.com/questions/18935539/authenticate-with-github-using-a-token

3. Command of Windows terminal 

 - replace keyword in file : https://www.generacodice.com/en/articolo/30745/How-can-you-find-and-replace-text-in-a-file-using-the-Windows-command-line-environment?


4. git command

 - git command auth firstly(pw is accessToken) : https://stackoverflow.com/questions/18935539/authenticate-with-github-using-a-token


5. 

a. View Binding

desc : replace findViewById and ButterKnife

references : 

 - https://developer.android.com/topic/libraries/view-binding
 - https://iter01.com/519924.html

step 1. config 

build.gradle

    android {
    ...
        // view binding setup
        buildFeatures {
            viewBinding true
        }
 
