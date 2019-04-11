package cn.star.clean.exception;

/**
 * @Description TODO
 * @Author leile
 * @Date 2019/4/1 上午10:15
 */
public class BusinessException extends RuntimeException {
    private int status;

    public BusinessException(){
        super();
    }
    public BusinessException(int status,String msg){
        super(msg);
        this.status = status;
    }
    public int getStatus() {
        return status;
    }
}