# QLDS-HoaDon
1 Chương trình quản lý hóa đơn tiền điện áp dụng các mẫu như: Three-Layer Architecture, Command Processor, Publisher/Subcriber, DAO/Gateway.
Đề bài
Xây dựng chương trình quản lý danh sách hoá đơn tiền điện của khách hàng. Thông tin bao gồm các loại khách hàng :
   Khách hàng Việt Nam: mã khách hàng, họ tên, ngày ra hoá đơn (ngày, tháng, năm), đối tượng khách hàng (sinh hoạt, kinh doanh, sản xuất): số lượng (số KW tiêu thụ), đơn giá, định mức.
  Thành tiền được tính như sau:
    - Nếu số lượng <= định mức thì: thành tiền = số lượng * đơn giá.
    - Ngược lại thì: thành tiền = số lượng * đơn giá * định mức + số lượng KW vượt định mức * Đơn giá * 2.5.
   Khách hàng nước ngoài: mã khách hàng, họ tên, ngày ra hoá đơn (ngày, tháng, năm), quốc tịch, số lượng, đơn giá. Thành tiền được tính = số lượng * đơn giá.
Yêu cầu:
   Thêm Hóa đơn
   Xóa Hóa đơn
   Sửa Hóa đơn
   Tính tổng số lượng cho từng loại khách hàng.
   Tính trung bình thành tiền của khách hàng người nước ngoài.
   Xuất ra các hoá đơn trong tháng nào đó.
   Tìm kiếm Hóa đơn
