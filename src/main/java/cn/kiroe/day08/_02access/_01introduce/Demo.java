package cn.kiroe.day08._02access._01introduce;

/**
 * @author kiro
 * @description:
 * @data 11:01 20/10/2023
 **/
/*

所以，我们就可以总结出，我们在实际开发中，使用<font color=red>**类中结构的访问权限修饰符**</font>的原则：

1. <span style=color:red;background:yellow>**尽量私有化**</span>，方便自己修改代码，隐藏实现细节。
2. 如果不能私有化，那也应该<span style=color:red;background:yellow>**尽量少的给予访问权限**</span>，先从默认权限开始考虑。
3. 只有确定这个结构，一定需要在外部（尤其是不同包下）被访问时，才考虑给public，<span style=color:red;background:yellow>**尽量少给public**</span>。

<span style=color:red;background:yellow>**权限这个东西，要吝啬，不要"大方"！**</span>


 */
public class Demo {


}
//无法使用
/*
public class A{

}
*/

class A{}
class B{}
//Modifier 'private' not allowed here
//private class C{}
//Modifier 'protected' not allowed here
//protected class D{}

class Outer{
    private class Inner{

    }
}

