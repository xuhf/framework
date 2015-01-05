// 登录名
jQuery.validator.addMethod("loginName", function(value, element) {
	var chrnum = /^([A-Za-z0-9_]+)$/;
	return this.optional(element) || (chrnum.test(value));
}, "请输入正确的用户名(字符A-Z，a-z,0-9和下划线)");

// 密码
jQuery.validator.addMethod("password", function(value, element) {
	var chrnum = /^([A-Za-z0-9_]+)$/;
	return this.optional(element) || (chrnum.test(value));
}, "请输入正确的用户名(字符A-Z，a-z,0-9和下划线)");

// 手机号码验证
jQuery.validator.addMethod("mobile", function(value, element) {
	var length = value.length;
	var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/
	return this.optional(element) || (length == 11 && mobile.test(value));
}, "手机号码格式错误");

// 电话号码验证
jQuery.validator.addMethod("phone", function(value, element) {
	var tel = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/;
	return this.optional(element) || (tel.test(value));
}, "电话号码格式错误");

// 邮政编码验证
jQuery.validator.addMethod("zipCode", function(value, element) {
	var tel = /^[0-9]{6}$/;
	return this.optional(element) || (tel.test(value));
}, "邮政编码格式错误");

// QQ号码验证
jQuery.validator.addMethod("qq", function(value, element) {
	var tel = /^[1-9]\d{4,10}$/;
	return this.optional(element) || (tel.test(value));
}, "QQ号码格式错误");

// IP地址验证
jQuery.validator
		.addMethod(
				"ip",
				function(value, element) {
					var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
					return this.optional(element)
							|| (ip.test(value) && (RegExp.$1 < 256
									&& RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256));
				}, "IP地址格式错误");

// 字母和数字的验证
jQuery.validator.addMethod("chrnum", function(value, element) {
	var chrnum = /^([a-zA-Z0-9]+)$/;
	return this.optional(element) || (chrnum.test(value));
}, "只能输入数字和字母(字符A-Z, a-z, 0-9)");

// 字母和数字的验证
jQuery.validator.addMethod("lowchrnum", function(value, element) {
	var chrnum = /^([a-z0-9]+)$/;
	return this.optional(element) || (chrnum.test(value));
}, "只能输入数字和字母(字符a-z, 0-9)");

// 中文的验证
jQuery.validator.addMethod("chinese", function(value, element) {
	var chinese = /^[\u4e00-\u9fa5]+$/;
	return this.optional(element) || (chinese.test(value));
}, "只能输入中文");

// 下拉框验证
$.validator.addMethod("selectNone", function(value, element) {
	return value == "请选择";
}, "必须选择一项");

// 字节长度验证
jQuery.validator.addMethod("byteRangeLength",
		function(value, element, param) {
			var length = value.length;
			for (var i = 0; i < value.length; i++) {
				if (value.charCodeAt(i) > 127) {
					length++;
				}
			}
			return this.optional(element)
					|| (length >= param[0] && length <= param[1]);
		}, $.validator.format("请确保输入的值在{0}-{1}个字节之间(一个中文字算2个字节)"));

// 字符验证
jQuery.validator.addMethod("stringCheck", function(value, element) {
	return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value);
}, "只能包括中文字、英文字母、数字和下划线");

// 中文字两个字节
jQuery.validator.addMethod("byteRangeLength",
		function(value, element, param) {
			var length = value.length;
			for (var i = 0; i < value.length; i++) {
				if (value.charCodeAt(i) > 127) {
					length++;
				}
			}
			return this.optional(element)
					|| (length >= param[0] && length <= param[1]);
		}, "请确保输入的值在3-15个字节之间(一个中文字算2个字节)");

// 身份证号码验证
jQuery.validator.addMethod("isIdCardNo", function(value, element) {
	return this.optional(element) || isIdCardNo(value);
}, "请正确输入您的身份证号码");

// 邮政编码验证
jQuery.validator.addMethod("isZipCode", function(value, element) {
	var tel = /^[0-9]{6}$/;
	return this.optional(element) || (tel.test(value));
}, "请正确填写您的邮政编码");
jQuery.validator.addMethod("isIpOrUrlOrDomain", function(value, element) {
	var isIpOrUrlOrDomain = false;
	if (isIP(value)) {
		isIpOrUrlOrDomain = true;
	} else if (isURL(value)) {
		isIpOrUrlOrDomain = true;
	} else if (isDomainName(value)) {
		isIpOrUrlOrDomain = true;
	}
	console.log(isIpOrUrlOrDomain);
	return this.optional(element) || (isIpOrUrlOrDomain);
}, "请正确填写IP/URL/域名");

function isIP(what) {
	if (what.search(/^\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}$/) == -1) {
		return false;
	}
	var fs = 0, ls = 0;
	var myArray = what.split(/\./);
	var i;
	for (i = 0; i < 4; i++) {
		if (!isNumeric(myArray[i]))
			return false;

		var t = parseInt(myArray[i]); /* 每个域值范围0-255 */
		if ((t < 0) || (t > 255))
			return false;
	}

	fs = parseInt(myArray[0]); // 取第一位进行校验
	ls = parseInt(myArray[3]); // 取最后一位进行校验

	/* 主机部分不能全是1和0（第一位不能为255和0），网络部分不能全是0（最后一位不能为0） */
	if ((fs == 255) || (fs == 0) || (ls == 0)) {
		return false;
	}
	return true;
};
function isURL(str) {
	var re = /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i;
	if (re.test(str)) {
		return true;
	} else {
		return false;
	}
};

function isDomainName(strdomain) {
	if (isEndomainname(strdomain) == false
			&& isCndomainname(strdomain) == false) {
		return false;
	} else {
		return true;
	}
};

function isEndomainname(strdomainname) {
	strdomainname = trimstring(strdomainname);
	arrayofstrings = strdomainname.split(".");
	if (arrayofstrings.length < 2) {
		return (false); // no enough parts
	}
	for (var i = 0; i < arrayofstrings.length; i++) {
		str = trimstring(arrayofstrings[i]);
		if (str.length == 0) {
			return (false); // empty part
		}
		re1 = /[^a-z0-9-]+/gi;
		match = re1.test(str);
		if (match)
			return (false); // non digit and character and '-' char

		re1 = /^-/;
		match = re1.test(str);
		if (match)
			return (false); // start with '-'

		re1 = /-$/;
		match = re1.test(str);
		if (match)
			return (false); // end with '-'
	}
	return (true);
};
function isCndomainname(strdomainname) {
	strdomainname = trimstring(strdomainname);
	arrayofstrings = strdomainname.split(".");
	if (arrayofstrings.length < 2) {
		return (false); // no enough parts
	}
	for (var i = 0; i < arrayofstrings.length; i++) {
		str = trimstring(arrayofstrings[i]);
		if (str.length == 0 || str.length > 20) {
			return (false);
		}
		re = /^[a-za-z0-9-u4e00-u9fa5ufe30-uffa0]+$/g;
		if (!re.test(str)) {
			return (false);
		}
		re = /^-/;
		if (re.test(str))
			return (false);
		re = /-$/;
		if (re.test(str))
			return (false);
	}
	return (true);
};

function trimstring(str) {
	var result;
	result = str.replace(/(^\s+)|(\s+$)/g, "");
	result = result.replace(/\s/g, "");
	return result.toString();
};

function isNumeric(strval) {
	var c;
	for (var i = 0; i < strval.length; i++) {
		c = strval.charAt(i);
		if (c < "0" || c > "9") {
			return false;
		}
	}
	return true;
};
