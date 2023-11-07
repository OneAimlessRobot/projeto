#!/bin/bash
separator="/"

rm -r ./outputs/outputs*.txt

java MainFromZero < "./inputs/1_in.txt" > "./outputs/outputs1.txt"
echo "DONE! 1"
diff ./outputs/outputs1.txt ./outputs/1_out.txt
java Main < "./inputs/2_in.txt" > "./outputs/outputs2.txt"
echo "DONE! 2"
diff ./outputs/outputs2.txt ./outputs/2_out.txt
java Main < "./inputs/3_in.txt" > "./outputs/outputs3.txt"
echo "DONE! 3"
diff ./outputs/outputs3.txt ./outputs/3_out.txt
java Main < "./inputs/4_in.txt" > "./outputs/outputs4.txt"
echo "DONE! 4"
diff ./outputs/outputs4.txt ./outputs/4_out.txt
java Main < "./inputs/5_in.txt" > "./outputs/outputs5.txt"
echo "DONE! 5"
diff ./outputs/outputs5.txt ./outputs/5_out.txt
java Main < "./inputs/6_in.txt" > "./outputs/outputs6.txt"
echo "DONE! 6"
diff ./outputs/outputs6.txt ./outputs/6_out.txt
java Main < "./inputs/7_in.txt" > "./outputs/outputs7.txt"
echo "DONE! 7"
diff ./outputs/outputs7.txt ./outputs/7_out.txt

echo "DONE!"
echo "DONE!"
echo "DONE!"
