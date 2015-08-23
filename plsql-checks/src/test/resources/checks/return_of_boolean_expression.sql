begin
  if (a = b) then -- violation
    return true;
  else
    return false;
  end if;
  
  if (a = b) then -- violation
    return false;
  else
    return true;
  end if;
  
  -- correct
  if (a = b) then
    return true;
  elsif (a = c) then
    return false;
  else
    return true;
  end if;
  
  if (a = b) then
    return true;
  else
    return true;
  end if;
  
  if (a = b) then
    return foo;
  else
    return false;
  end if;
  
  if (a = b) then
    a := 1;
    return true;
  else
    return false;
  end if;
  
  if (a = b) then
    return true;
  else
    a := 1;
    return false;
  end if;
end;