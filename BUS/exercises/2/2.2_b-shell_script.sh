#!/bin/bash

# test if argumaents were given
if [[ -z $1 ]] | [[ -z $2 ]]; then
    echo "The syntax is: ${PWD} {PID} {TIME}"
    exit
fi

PROCESS="$(ps | grep ${PID})"

# while process is running, print "Process {PID} running"
while [[  -n  $PROCESS ]]; do
    echo "process ${1} running"
    sleep $2
    PROCESS="$(ps | grep ${1})"
done

echo "Process not running"