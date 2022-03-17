package com.flowable.practice.service;

import com.flowable.practice.domain.vo.FlowTaskVo;
import org.flowable.bpmn.model.UserTask;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;

import java.io.InputStream;
import java.util.List;

/**
 * @author XuanXuan
 * @date 2021-04-03 14:42
 */
public interface IFlowTaskService {

    /**
     * 审批任务
     *
     * @param task 请求实体参数
     */
    String complete(FlowTaskVo task);

    /**
     * 驳回任务
     *
     * @param flowTaskVo
     */
    void taskReject(FlowTaskVo flowTaskVo);


    /**
     * 退回任务
     *
     * @param flowTaskVo 请求实体参数
     */
    void taskReturn(FlowTaskVo flowTaskVo);

    /**
     * 获取所有可回退的节点
     *
     * @param flowTaskVo
     * @return
     */
    List<UserTask> findReturnTaskList(FlowTaskVo flowTaskVo);

    /**
     * 删除任务
     *
     * @param flowTaskVo 请求实体参数
     */
    void deleteTask(FlowTaskVo flowTaskVo);

    /**
     * 认领/签收任务
     *
     * @param flowTaskVo 请求实体参数
     */
    void claim(FlowTaskVo flowTaskVo);

    /**
     * 取消认领/签收任务
     *
     * @param flowTaskVo 请求实体参数
     */
    void unClaim(FlowTaskVo flowTaskVo);

    /**
     * 委派任务
     *
     * @param flowTaskVo 请求实体参数
     */
    void delegateTask(FlowTaskVo flowTaskVo);


    /**
     * 转办任务
     *
     * @param flowTaskVo 请求实体参数
     */
    void assignTask(FlowTaskVo flowTaskVo);

    /**
     * 我发起的流程
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<HistoricProcessInstance> myProcess(Integer pageNum, Integer pageSize);

    /**
     * 取消申请
     * @param flowTaskVo
     * @return
     */
    String stopProcess(FlowTaskVo flowTaskVo);

    /**
     * 代办任务列表
     *
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @return
     */
    List<Task> todoList(Integer pageNum, Integer pageSize);


    /**
     * 已办任务列表
     *
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @return
     */
    List<HistoricTaskInstance> finishedList(Integer pageNum, Integer pageSize);

    /**
     * 流程历史流转记录
     *
     * @param procInsId 流程实例Id
     * @return
     */
    List<HistoricActivityInstance> flowRecord(String procInsId, String deployId);

    /**
     * 根据任务ID查询挂载的表单信息
     *
     * @param taskId 任务Id
     * @return
     */
    Task getTaskForm(String taskId);

    /**
     * 获取流程过程图
     * @param processId
     * @return
     */
    InputStream diagram(String processId);
}
