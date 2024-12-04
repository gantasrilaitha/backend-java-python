function hello(name?:string):string{
	if (name!=undefined){
		return "hihi"+name;
	}
	return "hihi";
}

function cal(fun:any):void{
	console.log(fun("aa"));
}
console.log(cal(hello));

//arrow function
var hh=(name:string)=>{
	return "how r u"+name;
}
console.log(hh('sri'));