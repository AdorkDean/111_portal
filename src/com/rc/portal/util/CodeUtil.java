package com.rc.portal.util;

import java.util.Random;

public class CodeUtil {
	// 生成4位纯数字的验证码
		public static String getVcode(int... codeCount) {
			int sum = 0;
			if (codeCount == null || codeCount.length == 0) {
				sum = 4;
			}
			for (int i = 0; i < codeCount.length; i++) {
				sum += codeCount[i];
			}
			// int codeCount =4;//验证码字符个数
			char[] codeSequence = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
					'9' };
			// 创建一个随机数生成器类
			Random random = new Random();
			// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
			StringBuffer randomCode = new StringBuffer();
			// 随机产生codeCount数字的验证码。
			for (int i = 0; i < sum; i++) {
				// 得到随机产生的验证码数字。
				String strRand = String.valueOf(codeSequence[random.nextInt(10)]);
				// 将产生的四个随机数组合在一起。
				randomCode.append(strRand);
			}
			return randomCode.toString();
		}

		// 生成4位数字+字母的推荐码
		public static String getNumVcode() {
			int codeCount = 6;// 验证码字符个数
			char[] codeSequence = { '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
					'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
					'Y', 'Z', '0' };
			// 创建一个随机数生成器类
			Random random = new Random();
			// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
			StringBuffer randomCode = new StringBuffer();
			// 随机产生codeCount数字的验证码。
			for (int i = 0; i < codeCount; i++) {
				// 得到随机产生的验证码数字。
				String strRand = String.valueOf(codeSequence[random.nextInt(36)]);
				// 将产生的四个随机数组合在一起。
				randomCode.append(strRand);
			}
			return randomCode.toString();
		}
}
