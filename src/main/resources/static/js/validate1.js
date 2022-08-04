var valid = false
function Validator(options) {
    var formElement = document.querySelector(options.form)

    options.rules.forEach(function (rule) {
        var inputElement = formElement.querySelector(rule.params) /// Lấy ra the input
        console.log(inputElement)
        if (inputElement) {// blur kiem tra xem nguoi dung vua bo con tro chuot ra ngoai
            inputElement.onblur = function () {
                var errMSG = rule.test(inputElement.value);
                var errEle = inputElement.parentElement.querySelector('msg')
                if (errMSG) {
                    errEle.innerText = errMSG
                    inputElement.classList.add('invalid')
                } else {
                    errEle.innerText = ''
                    inputElement.classList.add('valid')
                    inputElement.classList.remove('invalid')
                }
            }
        }
    });
}

Validator.checkName = function (params) {
    return {
        params: params,
        test: function (value) {
            return value.trim() ? undefined : 'Enter the name'
        }
    }
}
Validator.checkUsername = function (params) {
    return {
        params: params,
        test: function (value) {
            return value.trim() ? (value.trim().length < 6 ? 'Use 6 or more characters for username' : undefined) : 'Enter the username'
        }
    }
}
Validator.checkPassword = function (params) {
    return {
        params: params,
        test: function (value) {
            pass = value.trim();
            return value.trim() ? (value.trim().length < 6 ? 'Use 6 or more characters for password' : undefined) : 'Enter the password'
        }
    }
}
Validator.checkRePass = function (params) {
    return {
        params: params,
        test: function (value) {
            return value.trim() == pass ? (value.trim().length < 6 ? "Re-password not match" : undefined) : 'Those passwords didn’t match. Try again.'
        }
    }
}
/// Khoá nút submit khi chưa nhập đủ thông tin
setInterval((() => {
    var submit = document.getElementById('submit-btn');
    if (valid===false){
        submit.style.pointerEvents = 'none'
        submit.style.backgroundColor = '#f00'
    }else{
        submit.style.pointerEvents = 'auto'
        submit.style.backgroundColor = '#0085FC'
    }
    valid = checkValid();
    console.log(valid)

}),1000)
function checkValid(){
    var inputElements = document.querySelectorAll('input');
    if ((inputElements[0].value.length == 0 )|| inputElements[1].value.length < 6 || inputElements[2].value.length < 6 || inputElements[2].value != inputElements[3].value)
        return false
    return true
}