@echo off
REM Konfiguration aus Datei einlesen
for /f "delims=" %%a in (config.env) do set %%a

REM Verwendung der geladenen Variablen
echo Starte Verbindung zu %SERVER_IP%:%SERVER_PORT%
echo Benutzer: %USERNAME%
echo Passwort: %PASSWORD%

REM Verbindung simulieren
echo Verbindung zu %SERVER_IP% wird hergestellt...
timeout /t 2 >nul
echo Verbindung erfolgreich hergestellt!
