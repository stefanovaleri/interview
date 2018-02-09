#!/bin/bash

#
users=("Pippo" "Pluto" "Paperino" "Minnie" "Paperina")

for i in {1..10}
do
    time=`date +%s`

    randomIndex=`echo $RANDOM % 5 | bc`
    user=${users[$randomIndex]}

    randomValue=`echo "scale=5; $RANDOM/1000" | bc`
    
    echo $i $time $user $randomValue
    sleep 1
done
