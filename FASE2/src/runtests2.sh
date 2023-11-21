#!/bin/bash
separator="/"

rm -r ./outputs2/outputs*.txt

time java MainFromZero < "./inputs2/1_in.txt" > "./outputs2/outputs1.txt"
diff ./outputs/outputs1.txt ./outputs/1_out.txt
echo "DONE! 1"
time java Main < "./inputs2/2_in.txt" > "./outputs2/outputs2.txt"
diff ./outputs/outputs2.txt ./outputs/2_out.txt
echo "DONE! 2"
time java Main < "./inputs2/3_in.txt" > "./outputs2/outputs3.txt"
diff ./outputs/outputs3.txt ./outputs/3_out.txt
echo "DONE! 3"
time java Main < "./inputs2/4_in.txt" > "./outputs2/outputs4.txt"
diff ./outputs/outputs4.txt ./outputs/4_out.txt
echo "DONE! 4"
time java Main < "./inputs2/5_in.txt" > "./outputs2/outputs5.txt"
diff ./outputs/outputs5.txt ./outputs/5_out.txt
echo "DONE! 5"

echo "DONE!"
echo "DONE!"
echo "DONE!"
