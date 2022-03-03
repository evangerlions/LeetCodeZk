# 刷题常用方法
1. 字符串截取、数组截取、List 截取
``` java
// String.class
// 第二个 s 小写！从 beginIndex 截取到最后
String substring(int beginIndex)
// 从 beginIndex 截取到 endIndex
String substring(int beginIndex, int endIndex)

// Arrays.class
// 新建一个长度为 newLength 的数组，内容从原数组头部开始复制，多余空间填充默认值
static T[] copyOf(T[] originArray, int newLength)
// 范围 [from, to)，from == to 时得到空数组，to 可以超过原数组长度，多余空间填充默认值
static T[] copyOfRange(T[] originArray, int from, int to)

// List.class
// 用法和 array 相同，但是对 subList 的修改会同步到原 list 上
List<T> subList(int fromIndex, int toIndex)
// 如果不想影响到原数组
new ArrayList<T>(originList.subList(1, 2))
```
2. 数组的初始化
```java
int[] arr = new int[]{1, 2, 3};
int[] arr = new int[3];
```