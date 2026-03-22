select CONCAT("/home/grep/src/", B.BOARD_ID, "/", FILE_ID, FILE_NAME, FILE_EXT) as FILE_PATH from USED_GOODS_BOARD B join USED_GOODS_FILE F
on B.BOARD_ID = F.BOARD_ID
where B.BOARD_ID = (select BOARD_ID from USED_GOODS_BOARD 
                   where views = (select MAX(views) from USED_GOODS_BOARD))
order by FILE_ID desc;