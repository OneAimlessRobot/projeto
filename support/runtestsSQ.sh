#!/bin/bash
touch statFile
bash runtests.sh 2> statFile >> statFile
echo "1 DONE!!!!"
bash runtests.sh 2>> statFile >> statFile

echo "2 DONE!!!!"
bash runtests.sh 2>> statFile >> statFile

echo "3 DONE!!!!"
bash runtests.sh 2>> statFile >> statFile

echo "12 DONE!!!!"
bash runtests2.sh 2>> statFile >> statFile

echo "22 DONE!!!!"
bash runtests2.sh 2>> statFile >> statFile


echo "23 DONE!!!!"
bash runtests2.sh 2>> statFile >> statFile

