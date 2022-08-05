# Demoqa.com Test Task

Решение тестового задания

https://demoqa.com/
   Сайт: https://www.awesomescreenshot.com/video/9449793?key=b6fade3e318c5369a2b4771f363433e7 
   воспроизвести действия с помощью Selenium

Given the site "https://demoqa.com/"

It is required to reproduce actions shown in the following video with the help of Selenium:
https://www.awesomescreenshot.com/video/9449793?key=b6fade3e318c5369a2b4771f363433e7
  
Steps for the node registration in Selenium Grid via cmd:

1) >cd path\Selenium_Grid
2) \Selenium_Grid>java -jar selenium-server-standalone-4.0.0-alpha-2.jar –role hub -hubConfig HubConfig.json
3) \Selenium_Grid>nodeConfig.bat
4) \Selenium_Grid>runTestSuitCrossBrowserDemoqa.bat
