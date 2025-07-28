-zk + spring boot + pccsoftsys + pccsoft(GL)
-ใช้ maven package ไม่ได้เพราะไฟล์ไปไม่ครบ
   แก้โดยเพิ่ม resources ในไฟล์ pom.xml
-ต้องใส่ plugin ด้านล่างสำหรับตัวที่จะทำเป็นโมดูลต่างๆ ยกเว้นโมดุล webstart
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-compiler-plugin</artifactId>
		<!--<version>3.8.1</version>-->
		<!--<configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>-->
	</plugin>
	<plugin>
		<groupId>org.apache.maven.plugins</groupId>
		<artifactId>maven-jar-plugin</artifactId>
		<!--<version>3.1.0</version>-->
		<configuration>
			<archive>
				<manifest>
					<addDefaultImplementationEntries>true</addDefaultImplementationEntries>
				</manifest>
			</archive>
		</configuration>
	</plugin>