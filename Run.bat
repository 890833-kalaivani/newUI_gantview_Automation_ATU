echo "Starting Run.bat"
taskkill /F /IM IEDriverServer.exe
taskkill /F /IM Chromedriver.exe
taskkill /F /IM Chrome.exe
set projectLocation=%cd%
::cd %projectLocation%
mvn clean install

