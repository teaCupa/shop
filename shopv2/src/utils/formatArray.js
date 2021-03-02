//[o1,o2,o3,o4,o5...]->[[o1,o2,o3,o4],[o5]...]
export default function format(array) {
    let res=[]
    let subArray=[]
    if(array.length<=4){
        res.push(array)
    }else{
        for(let i=0;i<array.length;i+=4){
            if(i+3>=array.length)
                subArray=array.slice(i,array.length)
            else
                subArray=array.slice(i,i+4)
            res.push(subArray)
        }
    }
    return res
}
