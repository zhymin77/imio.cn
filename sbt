#!/bin/bash

if [[ 'prod' = $1 ]]; then
  mode='prod'
else
  mode='dev'
fi
./shell/proto $mode

p=$PWD

PATH=$PATH:$p/../../build/jdk/jdk1.7.0/bin
CLASSPATH=.:$p/../../build/jdk/jdk1.7.0/lib

$p/../../build/bin/sbt -DserverConfig="$p/resources/config/server.dev.conf"
