#!/bin/bash
separator="/"

rm -r ./outputs/outputs*.txt

java MainFromZero < "./inputs/1_in.txt" > "./outputs/outputs1.txt"
diff ./outputs/outputs1.txt ./outputs/1_out.txt
echo "DONE! 1"
java Main < "./inputs/2_in.txt" > "./outputs/outputs2.txt"
diff ./outputs/outputs2.txt ./outputs/2_out.txt
echo "DONE! 2"
java Main < "./inputs/3_in.txt" > "./outputs/outputs3.txt"
diff ./outputs/outputs3.txt ./outputs/3_out.txt
echo "DONE! 3"
java Main < "./inputs/4_in.txt" > "./outputs/outputs4.txt"
diff ./outputs/outputs4.txt ./outputs/4_out.txt
echo "DONE! 4"
java Main < "./inputs/5_in.txt" > "./outputs/outputs5.txt"
diff ./outputs/outputs5.txt ./outputs/5_out.txt
echo "DONE! 5"
java Main < "./inputs/6_in.txt" > "./outputs/outputs6.txt"
diff ./outputs/outputs6.txt ./outputs/6_out.txt
echo "DONE! 6"
java Main < "./inputs/7_in.txt" > "./outputs/outputs7.txt"
diff ./outputs/outputs7.txt ./outputs/7_out.txt
echo "DONE! 7"

echo "DONE!"
echo "DONE!"
echo "DONE!"
