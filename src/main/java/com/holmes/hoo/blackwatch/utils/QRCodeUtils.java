package com.holmes.hoo.blackwatch.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * @author A18081
 * @description 二维码生成工具类
 * @date 2019/06/05 11:27
 **/
public class QRCodeUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(QRCodeUtils.class);
    /**
     * 编码
     */
    private static final String CHARSET = "utf-8";
    /**
     * 二维码尺寸
     */
    private static final int QRCODE_SIZE = 250;

    public static BufferedImage generateZxingQRCode(String data) {
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 0);
        hints.put(EncodeHintType.QR_VERSION, 10);
        BitMatrix bitMatrix;
        BufferedImage image;
        try {
            bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
            image = new BufferedImage(QRCODE_SIZE, QRCODE_SIZE, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < QRCODE_SIZE; x++) {
                for (int y = 0; y < QRCODE_SIZE; y++) {
                    image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }
            return image;
        } catch (Exception e) {
            LOGGER.error("{}, 生成二维码异常!", Thread.currentThread().getStackTrace()[1].getMethodName(), e);
        }
        return null;
    }
}
