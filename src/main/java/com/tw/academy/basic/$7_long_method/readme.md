##### OrderReceipt 重构步骤

1. 重命名Order对象
2. 抽取打印发票的几个常量
3. 提取打印header方法
4. 提取打印客户信息方法，删除一些没用的注释
5. 提取常量：分隔符，换行符，消费折扣
6. 为LineItem添加计算单个销售费率的方法
7. 为LineItem添加拼接基本信息的方法
8. 替换OrderReceipt中获取LineItem基本信息
9. 在OrderReceipt中添加计算总销售税额的方法
10. 替换OrderReceipt中计算总销售税额的代码
11. 在Order中添加计算总销售税额方法，并替换OrderReceipt中获取总销售税额的代码
12. 在Order中添加计算销售总额方法，并替换OrderReceipt中获取销售总额的代码
13. 抽取OrderReceipt中打印LineItem详细信息的方法
14. inline OrderReceipt中使用总销售税额和总销售额的代码