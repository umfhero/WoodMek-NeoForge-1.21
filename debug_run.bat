@echo off
echo Running WoodMek with detailed logging...
echo.
gradlew.bat runClient --stacktrace --info --debug > debug_output.log 2>&1
echo.
echo Build completed. Check debug_output.log for details.
pause

