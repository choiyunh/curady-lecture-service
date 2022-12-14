package com.curady.lectureservice.global.service;

import com.curady.lectureservice.global.result.LecturesResult;
import com.curady.lectureservice.global.result.MultipleResult;
import com.curady.lectureservice.global.result.Result;
import com.curady.lectureservice.global.result.SingleResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ResponseService {

    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        setSuccessResult(result);
        result.setData(data);

        return result;
    }

    public <T> MultipleResult<T> getMultipleResult(List<T> data) {
        MultipleResult<T> result = new MultipleResult<>();
        setSuccessResult(result);
        result.setData(data);

        return result;
    }

    public <T> LecturesResult<T> getLecturesResult(int totalPage, long totalLecture, List<T> data) {
        LecturesResult<T> result = new LecturesResult<>();
        setSuccessResult(result);
        result.setTotalPage(totalPage);
        result.setTotalLecture(totalLecture);
        result.setData(data);

        return result;
    }

    public Result getSuccessResult() {
        Result result = new Result();
        setSuccessResult(result);

        return result;
    }

    public void setSuccessResult(Result result) {
        result.setSuccess(true);
        result.setCode(200);
        result.setMsg("성공");
    }

    public Result getFailureResult(int code, String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }
}