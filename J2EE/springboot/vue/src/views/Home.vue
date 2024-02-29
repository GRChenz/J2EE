<template>
    <div>
      <el-row :gutter="10" style="margin-bottom: 60px">
        <el-col :span="6">
          <el-card shadow="always" style="color: #F56C6C">
            <div > <i class="el-icon-s-opportunity"></i>能源总消耗</div>
            <div style="padding: 10px 0;text-align: center;font-weight: bold">
              <span v-model="ensum">120</span>
            </div>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card shadow="always" style="color:#67C23A">
            <div > <i class="el-icon-copy-document"></i>待办任务数</div>
            <div style="padding: 10px 0;text-align: center;font-weight: bold">
              <span v-model="project">2</span>
            </div>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card shadow="always" style="color:dodgerblue ">
            <div > <i class="el-icon-view"></i>监控教室数</div>
            <div style="padding: 10px 0;text-align: center;font-weight: bold">
              <span v-model="sumcla">15</span>
            </div>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card shadow="always" style="color:sandybrown ">
            <div > <i class="el-icon-tickets"></i>文件记录数</div>
            <div style="padding: 10px 0;text-align: center;font-weight: bold">
              <span v-model="sumfile">1</span>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12">
          <div id="main" style="width: 500px;height: 400px"></div>
        </el-col>
        <el-col :span="12">
          <div id="pie" style="width: 500px;height: 400px"></div>
        </el-col>
      </el-row>
    </div>
</template>


<script>

import * as echarts from 'echarts'

export default {
  name: "Home.vue",
  data(){
    return{

    }
  },
  mounted() {   //页面元素渲染后触发
    var chartDom = document.getElementById('main');
    var myChart = echarts.init(chartDom);
    var option = {
      xAxis: {
        type: 'category',
        data: []
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: [],
          type: 'line'
        },
        {
          data: [],
          type: 'bar'
        }
      ]
    };

    //从接口拿数据
    this.request.get("/echarts/weekcon").then(res => {
      option.xAxis.data=res.data.x
      option.series[0].data=res.data.y
      option.series[1].data=res.data.y
      //数据准备完毕才能set不然数据无法显示
      myChart.setOption(option);
    })
    //饼图

    var pieDom = document.getElementById('pie');//要连接到div的id
    var pieChart = echarts.init(pieDom);
    var pieoption = {
      title: {
        text: '各设备能耗饼图',
        subtext: '即时信息',
        left: 'center'
      },
      tooltip: {
        trigger: 'item'
      },
      legend: {
        orient: 'vertical',
        left: 'left'
      },
      series: [
        {
          type: 'pie',
          radius: '60%',
          label:{            //饼图图形上的文本标签
            normal:{
              show:true,
              position:'inner', //标签的位置
              textStyle : {
                fontWeight : 300 ,
                fontSize : 14,    //文字的字体大小
                color: "#fff"
              },
              formatter:'{d}%'
            }
          },
          data: [],  // 填空
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }
      ]
    };
    //从接口拿数据

    this.request.get("/echarts/allconsume").then(res => {
      pieoption.series[0].data = [
        {name: "电脑设备总用电量", value: (res.data.comnum)*50},
        {name: "LED设备总用电量", value: (res.data.lignum)*20},
        {name: "风扇设备总用电量", value: (res.data.fannum)*20},
        {name: "空调设备总用电量", value: (res.data.airnum)*100},
      ]
      //数据准备完毕才能set不然数据无法显示
      pieChart.setOption(pieoption);
    })

  }
}
</script>

<style scoped>

</style>