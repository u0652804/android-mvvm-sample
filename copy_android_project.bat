rename "arcComponetsSample" "test"

rmdir /s test\.git

rmdir /s test\.idea

rmdir /s test\.gradle

powershell -Command "(gc test\app\src\main\res\values\strings.xml) -replace 'arcComponetsSample', 'test' | Out-File test\app\src\main\res\values\strings.xml"