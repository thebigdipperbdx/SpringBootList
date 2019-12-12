#!/bin/bash
#这里可替换为你自己的执行程序，其他代码无需更改
APP_NAME=logwire-test-bl.jar

#使用说明，用来提示输入参数
usage() {
    echo "Usage: sh 执行脚本.sh [start|stop|restart|status]"
    exit 1
}

#检查程序是否在运行
is_exist(){
  pid=`ps -ef|grep $APP_NAME|grep -v grep|awk '{print $2}' `
  #如果不存在返回1，存在返回0     
  if [ -z "${pid}" ]; then
    echo "检查logwire_bl是否启动,检查结果暂无启动" 
   return 1
  else
    echo "检查logwire_bl是否启动,检查结果已经启动" 
    return 0
  fi
}

#启动方法
start(){
  is_exist
  if [ $? -eq "0" ]; then
    echo "${APP_NAME} is already running. pid=${pid} ."
  else
    echo "开始启动logwire_bl项目"
    nohup /app/bl_app/jdk1.8.0_231/bin/java -jar $APP_NAME > /app/logwire_bl/log/logs/log.txt &
    echo "开始查询logwire_bl启动日志"
    tail -f /app/logwire_bl/log/logs/log.txt
  fi
}

#停止方法
stop(){
  is_exist
  echo "开始停止logwire_bl项目"
  if [ $? -eq "0" ]; then
    kill -9 $pid
    echo "${APP_NAME} is stopping"
  else
    echo "${APP_NAME} is not running"
  fi  
}

#输出运行状态
status(){
  is_exist
   echo "开始查看运行状态"
  if [ $? -eq "0" ]; then
    echo "${APP_NAME} is running. Pid is ${pid}"
  else
    echo "${APP_NAME} is NOT running."
  fi
}

#重启
restart(){
   echo "开始重启logwire_bl项目"
  stop
  start
}

#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
  "start")
    start
    ;;
  "stop")
    stop
    ;;
  "status")
    status
    ;;
  "restart")
    restart
    ;;
  *)
    usage
    ;;
esac
