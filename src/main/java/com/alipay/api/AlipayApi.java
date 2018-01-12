package com.alipay.api;

import com.alipay.service.AlipayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * PayApi created with IntelliJ IDEA.
 * User: PengFei
 * Date: 2018-01-12
 * Time: 10:35
 */
@Controller
public class AlipayApi {

    @Resource
    private AlipayService alipayService;

    @RequestMapping("toPay")
    public ModelAndView toPay(
            @RequestParam(value = "paymentCode", defaultValue = "ZFB") String paymentCode,
            HttpServletResponse response
    ) {
        String form = "";
        if (paymentCode.equals("ZFB")) {
            form = alipayService.toPay();
        }
        response.setContentType("text/html, charset=UTF-8");
        try {
            response.getWriter().write(form);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.getWriter().flush();
                response.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
