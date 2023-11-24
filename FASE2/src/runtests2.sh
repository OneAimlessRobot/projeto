#!/bin/bash
rm -r ./outputs2/outputs*.txt
rm -r ./systemstate.res
time java Main < "./inputs2/1_in.txt" > "./outputs2/outputs1.txt"
diff ./outputs2/outputs1.txt ./outputs2/1_out.txt
echo "DONE! 1"
time java Main < "./inputs2/2_in.txt" > "./outputs2/outputs2.txt"
diff ./outputs2/outputs2.txt ./outputs2/2_out.txt
echo "DONE! 2"
time java Main < "./inputs2/3_in.txt" > "./outputs2/outputs3.txt"
diff ./outputs2/outputs3.txt ./outputs2/3_out.txt
echo "DONE! 3"
time java Main < "./inputs2/4_in.txt" > "./outputs2/outputs4.txt"
diff ./outputs2/outputs4.txt ./outputs2/4_out.txt
echo "DONE! 4"
time java Main < "./inputs2/5_in.txt" > "./outputs2/outputs5.txt"
diff ./outputs2/outputs5.txt ./outputs2/5_out.txt
echo "DONE! 5"

echo "DONE!"
echo "DONE!"
echo "DONE!"
