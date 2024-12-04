function hello(name) {
    if (name != undefined) {
        return "hihi" + name;
    }
    return "hihi";
}
function cal(fun) {
    console.log(fun("aa"));
}
console.log(cal(hello));
//arrow function
var hh = function (name) {
    return "how r u" + name;
};
console.log(hh('sri'));
