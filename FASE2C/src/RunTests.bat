del ..\resources\systemstate.res
java Main < inputs\1_in.txt > outputs\myOut1.txt
java Main < inputs\2_in.txt > outputs\myOut2.txt
java Main < inputs\3_in.txt > outputs\myOut3.txt
java Main < inputs\4_in.txt > outputs\myOut4.txt
java Main < inputs\5_in.txt > outputs\myOut5.txt
rem java Main < inputs\6_in.txt > outputs\myOut6.txt
RunDLL32 User32.dll,MessageBeep