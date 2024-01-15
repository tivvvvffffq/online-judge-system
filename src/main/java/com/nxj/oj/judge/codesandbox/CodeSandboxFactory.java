package com.nxj.oj.judge.codesandbox;


import com.nxj.oj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.nxj.oj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.nxj.oj.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * 代码沙箱工厂（根据字符串参数创建指定的代码沙箱实例）
 */
public class CodeSandboxFactory {

    /**
     * 创建代码沙箱示例
     *
     * @param type 沙箱类型
     * @return
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case SandboxType.EXAMPLE:
                return new ExampleCodeSandbox();
            case SandboxType.REMOTE:
                return new RemoteCodeSandbox();
            case SandboxType.THIRDPARTY:
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
