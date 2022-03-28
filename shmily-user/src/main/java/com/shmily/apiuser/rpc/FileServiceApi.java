package com.shmily.apiuser.rpc;

import com.poi.base.Result;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author WangXiang
 * @date 2022/3/27 20:31
 */
public interface FileServiceApi {
    Result uploadCos(MultipartFile[] files);
}
