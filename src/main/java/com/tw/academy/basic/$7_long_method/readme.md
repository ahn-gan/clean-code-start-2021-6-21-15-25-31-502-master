##### OrderReceipt 重构步骤

1. 重命名Order对象
2. 抽取打印发票的几个常量
3. 提取打印header方法
4. 提取打印客户信息方法，删除一些没用的注释
5. 提取常量：分隔符，换行符，消费折扣
6. 为LineItem添加计算单个销售费率的方法
7. 为LineItem添加拼接基本信息的方法
8. 替换OrderReceipt中获取LineItem基本信息
9. 在OrderReceipt中添加计算总销售税率的方法