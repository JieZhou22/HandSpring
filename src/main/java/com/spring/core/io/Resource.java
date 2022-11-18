package com.spring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: 周 杰
 * @Date: 2022/11/17/下午9:47
 * @Description: 处理资源加载流，提供获取 InputStream流的方法，接下来分别实现三种不同的流文件操作
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
