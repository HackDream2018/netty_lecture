namespace java thrift.generated

// 设置数据类型别名
typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String

// 实体
struct Person{
    1: optional String username,
    2: optional int age,
    3: optional boolean married
}

// 异常实体
exception DataException{
    1: optional String message,
    2: optional String callStack,
    3: optional String data
}

// 访问接口
service PersonService {
    Person getPersonByUsername(1: required String username)throws(1: DataException dataException),
    void savePerson(1: required Person person)throws(1: DataException dataException)
}