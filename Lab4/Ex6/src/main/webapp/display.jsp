<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>><%String name = (String)request.getAttribute("name");
        String email = (String)request.getAttribute("email");
        String birthday = (String)request.getAttribute("birthday");
        String birthtime = (String)request.getAttribute("birthtime");
        String gender = (String)request.getAttribute("gender");
        String country = (String)request.getAttribute("country");
        String[] ide = (String[])request.getAttribute("ide");
        String toeic = (String)request.getAttribute("toeic");
        String message = (String)request.getAttribute("message");
    %></title>
    <style>
        table {
            width: 70%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        table, th, td {
            border: 2px solid black;
        }
        th, td {
            padding: 15px;
            text-align: left;
        }
        th {
            font-size: 18px;
            color: #4a3b99;
            font-weight: bold;
        }
        td {
            font-size: 16px;
        }
        .label {
            font-weight: bold;
            color: #4a3b99;
        }
        .value {
            color: #2a9d2a;
        }
        .note {
            color: red;
            font-style: italic;
        }
    </style>
</head>
<body>

<table>
    <tr>
        <td class="label">Họ tên</td>
        <td class="value"><p><%out.println(name);%></p></td>
    </tr>
    <tr>
        <td class="label">Email</td>
        <td class="value"><%out.println(email);%></td>
    </tr>
    <tr>
        <td class="label">Ngày sinh</td>
        <td class="value"><%out.println(birthday);%></td>
    </tr>
    <tr>
        <td class="label">Giờ sinh</td>
        <td class="value"><%out.println(birthtime);%></td>
    </tr>
    <tr>
        <td class="label">Giới tính</td>
        <td class="value"><%
            if(gender == null) {
                gender = "";
            }
            out.println(gender);%></td>
    </tr>
    <tr>
        <td class="label">Quốc gia</td>
        <td class="value"><%
            if(country.contains("Select")) {
                country = "";
            }
            out.println(country);%></td>
    </tr>
    <tr>
        <td class="label">IDE Yêu thích <br> <p class="note">Hãy đảm bảo rằng các IDE bạn chọn đã hiển thị đủ</p></td>
        <td class="value">
            <%
                if(ide == null) {
                    ide = new String[0];
                }
                for(String ideName : ide) {
                out.println(ideName + "<br>");
            }
            %>
        </td>
    </tr>
    <tr>
        <td class="label">Điểm TOEIC</td>
        <td class="value"><%out.println(toeic);%></td>
    </tr>
    <tr>
        <td class="label">Giới thiệu bản thân</td>
        <td class="value"><%out.println(message);%></td>
    </tr>
</table>

</body>
</html>
