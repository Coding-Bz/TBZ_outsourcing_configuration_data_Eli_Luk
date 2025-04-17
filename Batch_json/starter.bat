@echo off

for /f "delims=" %%i in ('powershell -NoProfile -Command "(Get-Content config.json | ConvertFrom-Json).SERVER_IP"') do set SERVER_IP=%%i
for /f "delims=" %%i in ('powershell -NoProfile -Command "(Get-Content config.json | ConvertFrom-Json).PORT"') do set PORT=%%i

echo Verbinde mit Server %SERVER_IP% auf Port %PORT%
pause
