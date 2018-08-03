#!/bin/bash

#
users=("Pippo" "Pluto" "Paperino" "Minnie" "Paperina")

for i in {1..500}
do
    time=`date +%s`

    randomIndex=$(($RANDOM % 5))
    user=${users[$randomIndex]}

    value=`echo "scale=2; $RANDOM/1000" | bc`
    
    echo $i $time $user $value
    sleep $randomIndex
done
